function checkQuantity(){
    var message = document.getElementById("message-quantity").innerText;
    if(message==="error"){
        alert("Số lượng bạn yêu cầu vượt quá số lượng trong kho");
        document.getElementById("message-quantity").innerText-=`error`;
        location="/";
    }
}