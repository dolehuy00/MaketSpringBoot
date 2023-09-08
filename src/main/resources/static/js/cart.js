function checkQuantity() {  
    var message = document.getElementById("message-quantity").innerText;
    if(message==="error"){
        alert("Số lượng bạn yêu cầu vượt quá số lượng trong kho");
        document.getElementById("message-quantity").innerText-=`error`;
    }
}
function checkInputQuantity(id){
    var quantity = document.getElementById("quatity-product-"+id).value;
    if(quantity===""||parseInt(quantity)<=0){
        alert("Số lượng không hợp lệ!");
        document.getElementById("quatity-product-"+id).value=1;
        document.getElementById("update-form-"+id).submit();
    }else{
        document.getElementById("update-form-"+id).submit();
    }
} 
function checkOut() {
    alert("Thanh toán thành công");
}