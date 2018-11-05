<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 10/9/2018
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<body>
<!-- Cart -->
<section class="cart bgwhite p-t-70 p-b-100">
    <div class="container">
        <!-- Cart item -->
        <div class="container-table-cart pos-relative">
            <div class="wrap-table-shopping-cart bgwhite">
                <table class="table-shopping-cart">
                    <tr class="table-head">
                        <th class="column-1"></th>
                        <th class="column-2">Product</th>
                        <th class="column-3">Size</th>
                        <th class="column-3">color</th>
                        <th class="column-3 ">Price</th>
                        <th class="column-4 p-l-70">Quantity</th>
                        <th class="column-5">Total</th>
                    </tr>
                    <c:forEach var="cart" items="${detailcart}">
                        <tr class="table-row">
                            <td class="column-1">
                                <div class="cart-img-product b-rad-4 o-f-hidden">
                                    <img src="/resources/images/sanpham/${cart.image}"/>
                                </div>
                            </td>
                            <td class="column-2 idproduct" data-idproduct="${cart.idProduct}">${cart.productName}</td>
                            <td class="column-3 idsize " data-idsize="${cart.idSize}">${cart.sizeName}</td>
                            <td class="column-3 idcolor" data-idcolor="${cart.idColor}">${cart.colorName}</td>
                            <td class="column-3 priceproduct" id="price">${cart.price}</td>
                            <td class="column-4">
                                <div class="flex-w bo5 of-hidden w-size17">
                                    <button class="btn-product btn-num-product-down color1 flex-c-m size7 bg8 eff2">
                                        <i class="fs-12 fa fa-minus" aria-hidden="true"></i>
                                    </button>

                                    <input class="size8 m-text18 t-center num-product data-amount"  min="1" type="number"   value="${cart.amount}">

                                    <button class=" btn-product btn-num-product-up color1 flex-c-m size7 bg8 eff2">
                                        <i class="fs-12 fa fa-plus" aria-hidden="true"></i>
                                    </button>
                                </div>
                            </td>
                            <td class="column-5 total" ></td>
                            <td class="column-5 "><input class="btn-delete" type="image" src="/template/web/images/icons/rubbish-bin.png"></input></td>

                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>

        <div class="flex-w flex-sb-m p-t-25 p-b-25 bo8 p-l-35 p-r-60 p-lr-15-sm">
            <div class="flex-w flex-m w-full-sm">
                <div class="size11 bo4 m-r-10">
                    <input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="coupon-code" placeholder="Coupon Code">
                </div>

                <div class="size12 trans-0-4 m-t-10 m-b-10 m-r-10">
                    <!-- Button -->
                    <button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
                        Apply coupon
                    </button>
                </div>
            </div>

            <div class="size10 trans-0-4 m-t-10 m-b-10">
                <!-- Button -->
                <button id="checkout" class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4" data-user="${iduer}">
                    Update Cart
                </button>
            </div>
        </div>

        <!-- Total -->
        <div class="bo9 w-size18 p-l-40 p-r-40 p-t-30 p-b-38 m-t-30 m-r-0 m-l-auto p-lr-15-sm">
            <h5 class="m-text20 p-b-24">
                Cart Totals
            </h5>

            <!--  -->
            <div class="flex-w flex-sb-m p-b-12">
					<span class="s-text18 w-size19 w-full-sm">
						Subtotal:
					</span>

                <span id="subtotal" class="m-text21 w-size20 w-full-sm">

					</span>
            </div>

            <!--  -->
            <div class="flex-w flex-sb bo10 p-t-15 p-b-20">
					<span class="s-text18 w-size19 w-full-sm">
						Shipping:
					</span>

                <div class="w-size20 w-full-sm">
                    <p class="s-text8 p-b-23">
                        There are no shipping methods available. Please double check your address, or contact us if you need any help.
                    </p>

                    <span class="s-text19">
							Calculate Shipping
						</span>

                    <div class="rs2-select2 rs3-select2 rs4-select2 bo4 of-hidden w-size21 m-t-8 m-b-12">
                        <select class="selection-2" name="country">
                            <option>Select a country...</option>
                            <option>US</option>
                            <option>UK</option>
                            <option>Japan</option>
                        </select>
                    </div>

                    <div class="size13 bo4 m-b-12">
                        <input class="sizefull s-text7 p-l-15 p-r-15" type="text" name="state" placeholder="State /  country">
                    </div>

                    <div class="size13 bo4 m-b-22">
                        <input class="sizefull s-text7 p-l-15 p-r-15" type="text" name="postcode" placeholder="Postcode / Zip">
                    </div>

                    <div class="size14 trans-0-4 m-b-10">
                        <!-- Button -->
                        <button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4" >
                            Update Totals
                        </button>
                    </div>
                </div>
            </div>

            <!--  -->
            <div class="flex-w flex-sb-m p-t-26 p-b-30">
					<span class="m-text22 w-size19 w-full-sm">
						Total:
					</span>

                <span class="m-text21 w-size20 w-full-sm">
						$39.00
					</span>
            </div>

            <div class="size15 trans-0-4">
                <!-- Button -->
                <button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
                    Proceed to Checkout
                </button>
            </div>
        </div>
    </div>
</section>
<script type="text/javascript">
    $(document).ready(function ()
    {

        sumMoneyOfProduct();
       // confirmDelete();
        function sumMoneyOfProduct()
        {
            var subTotal=0;
            $('.priceproduct').each(function ()
            {
                var price = $(this).text();
                var amount = $(this).closest("tr").find(".data-amount").val();

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
                $(this).closest("tr").find('.total').html(formatCurrency);
            })

            subTotal=subTotal.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.");
            $('#subtotal').text(subTotal);

        }
        $(".btn-product").click(function()
        {
            var amount=$(this).closest("tr").find(".data-amount").val();
            var idProduct=$(this).closest("tr").find(".idproduct").attr("data-idproduct");
            var idSize=$(this).closest("tr").find(".idsize").attr("data-idsize");
            var idColor=$(this).closest("tr").find(".idcolor").attr("data-idcolor");

            //call back to assign subtotal
             sumMoneyOfProduct();
            $.ajax({
                url:"/ajax/updatecart",
                type:"GET",
                data:
                {
                    amount:amount,
                    idProduct:idProduct,
                    idSize:idSize,
                    idColor:idColor
                },
                success:function ()
                {

                }
            })

        })

         $("body").on("click",".btn-delete",function ()
        {
            // e.preventDefault();
            var self=$(this);
            var idProduct=$(this).closest("tr").find(".idproduct").attr("data-idproduct");
            var idSize=$(this).closest("tr").find(".idsize").attr("data-idsize");
            var idColor=$(this).closest("tr").find(".idcolor").attr("data-idcolor");
            swal({
                title: "Xác nhận xóa",
                text: "Bạn có chắc chắn xóa những dòng đã chọn",
                type: "warning",
                showCancelButton: true,
                confirmButtonText: "Xác nhận",
                cancelButtonText: "Hủy bỏ",
                closeOnConfirm: false

            }).then(function (isConfirm)
            {
                if (!isConfirm) return;
                $.ajax({
                    url: "/ajax/deletecart",
                    type:"GET",
                    data:
                        {
                            idProduct:idProduct,
                            idSize:idSize,
                            idColor:idColor
                        },
                    success: function ()
                    {

                        swal("Done!", "It was succesfully deleted!", "success");
                        self.closest("tr").remove();

                    }
                    ,
                    error: function (xhr, ajaxOptions, thrownError)
                    {
                        swal("Error deleting!", "Please try again", "error");
                    }

                });
            });

        })

        $("#checkout").click(function ()
        {


            var idUser= $(this).attr("data-user");
            if(idUser==null || idUser=="")
            {
                // swal( "please ","login to continue shopping", "success");

                // $(this).addClass('js-addedwish-detail');
                // $(this).off('click');
                swal({
                    title: "Wow!",
                    text: "please login to continue shopping !",
                    type: "success"
                }).then(function() {
                    currentLink = window.location.href;
                    link = currentLink.replace("/product-cart", "/login");

                    window.location = link;
                });


            }
            else
            {
                currentLink = window.location.href;
                link = currentLink.replace("/product-cart", "/product-checkout");

                window.location = link;
            }
        })


    })

</script>
</body>
</html>
