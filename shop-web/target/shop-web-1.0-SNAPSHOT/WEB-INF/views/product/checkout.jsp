<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<!-- ##### Checkout Area Start ##### -->
<div class="checkout_area section-padding-80">
    <div class="container">
        <div class="row">

            <div class="col-12 col-md-6">
                <div class="checkout_details_area mt-50 clearfix">

                    <div id="detail" class="cart-page-heading mb-30">
                        <h5>Billing Address</h5>
                    </div>

                    <form   id="formcheckout" method="post">
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="customerName"> Name <span>*</span></label>
                                <input type="text" class="form-control" id="customerName"  name="customerName" value="" required>
                            </div>



                            <div class="col-12 mb-3">
                                <label for="addressDelivery">Address <span>*</span></label>
                                <input type="text" name="addressDelivery" class="form-control mb-3" id="addressDelivery" value="">
                            </div>



                            <div class="col-12 mb-3">
                                <label for="phoneNumber">Phone No <span>*</span></label>
                                <input  type="number" name="phoneNumber" class="form-control" id="phoneNumber" min="0" value="">
                            </div>



                        </div>

                </div>
            </div>

            <div class="order col-12 col-md-6 col-lg-5 ml-lg-auto">
                <div class="order-details-confirmation">

                    <div class="cart-page-heading">
                        <h5>Your Order</h5>
                        <p>The Details</p>
                    </div>

                    <ul class="order-details-form mb-4">
                        <li><span>Product</span> <span>Total</span></li>
                        <c:forEach var="item" items="${checkout}" >
                            <li><span>${item.productName}</span  ><span >${item.amount}</span><span>x</span> <span class="priceproduct" data-amount="${item.amount}">${item.price}</span></li>
                        </c:forEach>
                        <li><span>Subtotal</span> <span>$59.90</span></li>
                        <li><span>Shipping</span> <span>Free</span></li>
                        <li><span>Total</span> <span  id="total"></span></li>
                    </ul>


                    <input type="submit" class="btn essence-btn" value="Place Order"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ##### Checkout Area End ##### -->
<script type="text/javascript">
    $(document).ready(function ()
    {
         $('.btn').click(function (event)
         {
             $('#formcheckout').validate(
             {
                 rules: [],
                 messages: [],
                 submitHandler: function(form)
                 {
                     event.preventDefault();
                     var formcheckout = $("#formcheckout").serializeArray();
                     json = {};
                     $.each(formcheckout, function (key, value) {
                         json[value.name] = value.value;
                     })
                     $.ajax(
                         {
                              url:"/ajax/bill",
                             type:"post",
                             data: {
                                 dataJson: JSON.stringify(json)
                             },
                             success: function (value)
                             {

                             }

                         })
                 }

             });
             $("#customerName").rules("add", {
                 required: true,
                 messages:
                     {
                         required: "The name is not empty"
                     }
             });
             $("#addressDelivery").rules("add", {
                 required: true,
                 messages:
                     {
                         required: "Address is not empty",
                     }
             });
             $("#phoneNumber").rules("add", {
                 required: true,
                 messages:
                     {
                         required: "phone is not empty",
                     }

             });

         })
        loadPrice();
        function loadPrice()
        {
            var subTotal=0;
            $('.priceproduct').each(function ()
            {
                var price = $(this).text();
                var amount = $(this).attr("data-amount");
                var formatCurrency = "";

                for (var i = 0; i < price.length; i++)
                {


                    if (price[i] == ".") {
                        formatCurrency = formatCurrency + (price[i].replace(".", ""));
                    }
                    else {
                        formatCurrency = formatCurrency + price[i];
                    }
                }
                formatCurrency = formatCurrency * amount;
                subTotal=(subTotal+parseFloat(formatCurrency));
                formatCurrency = formatCurrency.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.");
            })
            subTotal=subTotal.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.");
            $("#total").text(subTotal);

        }
    })
</script>
</body>
</html>
