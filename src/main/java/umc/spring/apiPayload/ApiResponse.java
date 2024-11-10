package umc.spring.apiPayload;

import umc.spring.apiPayload.code.BaseCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.apiPayload.code.status.SuccessStatus;

@Getter //getter 자동생성
@AllArgsConstructor //클래스이 모든 필드를 포함하는 생성자 자동으로 생성
@JsonPropertyOrder({"isSuccess","code","message","result"}) //json 직렬화 시 필드 출력 순서 지정
public class ApiResponse<T> { //통일된 API응답을 위한 클래스

    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;


    // 성공한 경우 응답 생성

    public static <T> ApiResponse<T> onSuccess(T result){
        return new ApiResponse<>(true, SuccessStatus._OK.getCode() , SuccessStatus._OK.getMessage(), result);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T result){
        return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
    }


    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data){
        return new ApiResponse<>(false, code, message, data);
    }

} //일관된 형식의 Json 응답을 반환하도록 도와준다.
