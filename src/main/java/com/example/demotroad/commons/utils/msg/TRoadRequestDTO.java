package com.example.demotroad.commons.utils.msg;

import java.util.Map;

public class TRoadRequestDTO {

    private String agreementId;

    private String requestBody;

    private String requestBy;

    public RequestHeaders requestHeadersObject;

    public String requestMethod;

    private String ticketNo;

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }

    public RequestHeaders getRequestHeadersObject() {
        return requestHeadersObject;
    }

    public void setRequestHeadersObject(RequestHeaders requestHeadersObject) {
        this.requestHeadersObject = requestHeadersObject;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    @Override
    public String toString() {
        return "TRoadRequestDTO{" +
                "agreementId='" + agreementId + '\'' +
                ", requestBody='" + requestBody + '\'' +
                ", requestBy='" + requestBy + '\'' +
                ", requestHeadersObject=" + requestHeadersObject +
                ", requestMethod='" + requestMethod + '\'' +
                ", ticketNo='" + ticketNo + '\'' +
                '}';
    }


    public class RequestHeaders {
        private String additionalProp1;
        private String additionalProp2;


        // Getter Methods

        public String getAdditionalProp1() {
            return additionalProp1;
        }

        public String getAdditionalProp2() {
            return additionalProp2;
        }

        // Setter Methods

        public void setAdditionalProp1(String additionalProp1) {
            this.additionalProp1 = additionalProp1;
        }

        public void setAdditionalProp2(String additionalProp2) {
            this.additionalProp2 = additionalProp2;
        }
    }

}
