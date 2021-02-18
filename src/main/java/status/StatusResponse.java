/**
 * @author : Arjun Gautam
 * e-mail : arjungautam5431@gmail.com
 * Date :2021-02-18
 * Time :10:34
 */
package status;

public enum StatusResponse {
    SUCCESS("Success"),
    ERROR("Error");

    final private String status;

    StatusResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
