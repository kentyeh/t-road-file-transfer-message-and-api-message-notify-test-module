package com.example.demotroad.commons.utils.msg;

public class TRoadResponseDTO {

    private Integer code;
    private String message;

    private Integer responseCode;

    public ResponseHeaders ResponseHeadersObject;

    private String result;

    private String ticketNo;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Integer getcode() {
        return this.code;
    }

    public TRoadResponseDTO code(Integer code) {
        this.setcode(code);
        return this;
    }

    public void setcode(Integer code) {
        this.code = code;
    }

    public String getmessage() {
        return this.message;
    }

    public TRoadResponseDTO message(String message) {
        this.setmessage(message);
        return this;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public Integer getresponseCode() {
        return this.responseCode;
    }

    public TRoadResponseDTO responseCode(Integer responseCode) {
        this.setresponseCode(responseCode);
        return this;
    }

    public void setresponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public ResponseHeaders getResponseHeaders() {
        return ResponseHeadersObject;
    }

    public void setResponseHeaders(ResponseHeaders responseHeadersObject) {
        this.ResponseHeadersObject = responseHeadersObject;
    }

    public String getresult() {
        return this.result;
    }

    public TRoadResponseDTO result(String result) {
        this.setresult(result);
        return this;
    }

    public void setresult(String result) {
        this.result = result;
    }

    public String getticketNo() {
        return this.ticketNo;
    }

    public TRoadResponseDTO ticketNo(String ticketNo) {
        this.setticketNo(ticketNo);
        return this;
    }

    public void setticketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here
    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TRoadResponseDTO{"
                + " code='" + getcode() + "'"
                + ", message='" + getmessage() + "'"
                + ", responseCode='" + getresponseCode() + "'"
                + ", result='" + getresult() + "'"
                + ", ticketNo='" + getticketNo() + "'"
                + "}";
    }

    public class ResponseHeaders {

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
