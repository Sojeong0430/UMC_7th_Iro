package umc.spring.apiPayload.code;

//구체화하는 Status에서 두 개의 메소드를 반드시 Override할 것을 강제하는 역할을함
public interface BaseCode {

    ReasonDTO getReason();
    ReasonDTO getReasonHttpStatus();

}
