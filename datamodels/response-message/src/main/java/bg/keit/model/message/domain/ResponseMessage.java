package bg.keit.model.message.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "messages")
public class ResponseMessage implements java.io.Serializable {
    @Id
    long id;
    @Column (nullable = false)
    int code;
    @Column (nullable = false)
    String message;
    @Column (nullable = false)
    String value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseMessage that = (ResponseMessage) o;
        return id == that.id &&
                code == that.code &&
                Objects.equals(message, that.message) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, code, message, value);
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "id=" + id +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
