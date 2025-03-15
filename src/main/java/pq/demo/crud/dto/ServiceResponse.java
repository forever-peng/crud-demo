package pq.demo.crud.dto;

import lombok.Data;

import java.util.HashMap;
@Data
public class ServiceResponse<TData> {
    public static final int SUCCESS_CODE = 0;
    private int code;
    private boolean success;
    private TData data;
    private String message;
    private HashMap<String, Object> other;



    public static <TData> ServiceResponse<TData> buildSuccessResponse(TData data)
    {
        return new ServiceResponse<TData>(0, true, data, "", (HashMap) null);
    }

    /**什么时候会传message
     */
    public static <TData> ServiceResponse<TData> buildSuccessResponse(TData data, String message)
    {
        return new ServiceResponse<TData>(0, true, data, message, (HashMap) null);
    }



    public Object getExtra(String key)
    {
        return this.other == null ? null : this.other.get(key);
    }

    public void putExtra(String key, Object value)
    {
        if (this.other == null)
        {
            this.other = new HashMap();
        }

        this.other.put(key, value);
    }

    public ServiceResponse()
    {
    }

    public ServiceResponse(int code, boolean success, TData data, String message, HashMap<String, Object> other)
    {
        this.code = code;
        this.success = success;
        this.data = data;
        this.message = message;
        this.other = other;
    }
}
