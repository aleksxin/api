package bg.keit.client.mobile.json;

import java.io.Serializable;
import java.util.Date;

public class RespMessage implements Serializable{
    int code;
    String status;
    String message;
    Date message_date;
    Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessage_date() {
        return message_date;
    }

    public void setMessage_date(Date message_date) {
        this.message_date = message_date;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
