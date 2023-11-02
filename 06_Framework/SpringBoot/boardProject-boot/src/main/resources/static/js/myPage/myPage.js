function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailAddress").focus();
        }
    }).open();
}

//--------------------------------------------------------------------------------

/* 프로필 이미지 미리보기, 제거 */
const profileImg = document.querySelector("#profileImg"); // img 태그
const imageInput = document.querySelector("#imageInput"); // input 태그
const deleteImage = document.querySelector("#deleteImage"); // x 태그

if(imageInput != null) { // #imageInput 존재할 때 

    /* 프로필 이미지 변경(선택) 시 수행할 함수 */
    const changeImageFn = e => {

        console.log(e.target); // input태그
        console.log(e.target.value); // value -> 업로드 파일 경로가 나옴(fakepath 형태로 출력) // C:\fakepath\sample5.jpg

        /* 이게 중요! 파일의 정보가 담긴 배열이 담겨있기 때문에!*/
        console.log(e.target.files); // 업로드된 파일의 정보가 담긴 배열 반환
                                     // *실제 파일 *

        console.log(e.target.files[0]); // 업로드된 파일 중 첫 번째 파일

        const uploadFile = e.target.files[0]; 

        // --------------------------- 선택된 파일의 크기가 지정된 크기를 초과하는 경우 -----------------------------------------
        const maxSize = 1024 * 1024 ; // 1MB (byte 단위)

        if(uploadFile.size > maxSize) { 
            alert("1MB 이하의 이미지만 업로드 가능합니다");

            // 최대 크기를 초과해도 input에 value가 남기 때문에 
            // 이를 제거하는 코드가 필요하다! 
            imageInput.value = ''; // value 삭제
                                // 동시에 files도 삭제됨

            return;
        }

        // ----------- 선택된 이미지 파일을 읽어와 미리 보기 만들기 --------------
        



    }



    /* 이미지 선택 버튼을 클릭하여 선택된 파일이 변했을 때 함수 수행  */

    // change 이벤트 : input의 이전 값과 현재 값이 다를 때 발생
    imageInput.addEventListener("change", changeImageFn);
}
