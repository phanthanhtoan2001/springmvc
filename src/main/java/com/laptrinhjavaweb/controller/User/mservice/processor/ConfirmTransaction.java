package com.laptrinhjavaweb.controller.User.mservice.processor;

import com.laptrinhjavaweb.controller.User.mservice.config.Environment;
import com.laptrinhjavaweb.controller.User.mservice.enums.ConfirmRequestType;
import com.laptrinhjavaweb.controller.User.mservice.enums.Language;
import com.laptrinhjavaweb.controller.User.mservice.models.*;
import com.laptrinhjavaweb.controller.User.mservice.shared.constants.Parameter;
import com.laptrinhjavaweb.controller.User.mservice.shared.exception.MoMoException;
import com.laptrinhjavaweb.controller.User.mservice.shared.utils.Encoder;
import com.laptrinhjavaweb.controller.User.mservice.shared.utils.LogUtils;

public class ConfirmTransaction extends AbstractProcess<ConfirmRequest, ConfirmResponse> {
	public ConfirmTransaction(Environment environment) {
		super(environment);
	}

	public static ConfirmResponse process(Environment env, String orderId, String requestId, String amount,
			ConfirmRequestType requestType, String description) throws Exception {
		try {
			ConfirmTransaction m2Processor = new ConfirmTransaction(env);

			ConfirmRequest request = m2Processor.createConfirmTransactionRequest(orderId, requestId, amount,
					requestType, description);
			ConfirmResponse response = m2Processor.execute(request);

			return response;
		} catch (Exception exception) {
			// LogUtils.error("[ConfirmTransactionProcess] "+ exception);
		}
		return null;
	}

	@Override
	public ConfirmResponse execute(ConfirmRequest request) throws MoMoException {
		try {

			String payload = getGson().toJson(request, ConfirmRequest.class);

			HttpResponse response = execute.sendToMoMo(environment.getMomoEndpoint().getConfirmUrl(), payload);

			if (response.getStatus() != 200) {
				throw new MoMoException("[ConfirmTransactionResponse] [" + request.getOrderId() + "] -> Error API");
			}

			// System.out.println("uweryei7rye8wyreow8: "+ response.getData());

			ConfirmResponse confirmResponse = getGson().fromJson(response.getData(), ConfirmResponse.class);
			String responserawData = Parameter.ORDER_ID + "=" + confirmResponse.getOrderId() + "&" + Parameter.MESSAGE
					+ "=" + confirmResponse.getMessage() + "&" + Parameter.RESULT_CODE + "="
					+ confirmResponse.getResultCode();
			System.out.println("\n\\\n\\n\\n\\n\\n\\n\\n\\n\\n\\nn\n\n\n" + confirmResponse.getMessage() + "/"
					+ confirmResponse.getResultCode() + "\n");
			// LogUtils.info("[ConfirmTransactionResponse] rawData: " + responserawData);
			System.out.println(confirmResponse.getResultCode());
			return confirmResponse;

		} catch (Exception exception) {
			// LogUtils.error("[ConfirmTransactionResponse] "+ exception);
			throw new IllegalArgumentException("Invalid params confirm MoMo Request");
		}
	}

	public ConfirmRequest createConfirmTransactionRequest(String orderId, String requestId, String amount,
			ConfirmRequestType requestType, String description) {

		try {
			String requestRawData = new StringBuilder().append(Parameter.ACCESS_KEY).append("=")
					.append(partnerInfo.getAccessKey()).append("&").append(Parameter.AMOUNT).append("=").append(amount)
					.append("&").append(Parameter.DESCRIPTION).append("=").append(description).append("&")
					.append(Parameter.ORDER_ID).append("=").append(orderId).append("&").append(Parameter.PARTNER_CODE)
					.append("=").append(partnerInfo.getPartnerCode()).append("&").append(Parameter.REQUEST_ID)
					.append("=").append(requestId).append("&").append(Parameter.REQUEST_TYPE).append("=")
					.append(requestType.getConfirmRequestType()).toString();

			String signRequest = Encoder.signHmacSHA256(requestRawData, partnerInfo.getSecretKey());
			// LogUtils.debug("[ConfirmRequest] rawData: " + requestRawData + ", [Signature]
			// -> " + signRequest);

			return new ConfirmRequest(partnerInfo.getPartnerCode(), orderId, requestId, Language.EN,
					Long.valueOf(amount), "", ConfirmRequestType.CAPTURE, signRequest);
		} catch (Exception e) {
			// LogUtils.error("[ConfirmResponse] "+ e);
		}

		return null;
	}
}
