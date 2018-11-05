<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="container-fluid">
    <div class="side-body">
    <div class="ChiTietDonHang table">
    <table class="table" id="table">

        <tr>
            <td colspan="4">
                <table style="width:100%;">

                </table>

            </td>
        </tr>






        <tr>
            <td><b>Sản phẩm</b></td>
            <td><b>Hình ảnh</b></td>
            <td><b>Số lượng đặt</b></td>
            <td><b>Đơn giá đặt</b></td>
        </tr>




        <tr>
            <td align="right" colspan="4">Tổng số lượng: sản phẩm</td>
        </tr>
        <tr>
            <td align="right" colspan="4">Tổng tiền: đồng</td>
        </tr>
    </table>
    <br /><br />
    <input type="submit" value="Lưu đơn hàng"  id="btnInDonHang" />
</div>



<div class="hienthisanpham">
    <div class="card">

        <div class="col-right">
            <table class="timkiem">
                <tr>
                    <td><input type="text" class="form-control" id="txt-timkiemsanpham" placeholder="Nhập tên sản phẩm cần tìm"/></td>
                    <td><button id="btn-timkiemsanpham" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button></td>
                </tr>
            </table>
        </div>

        <table class="table">
            <thead>
            <tr>

                <th>
                    Chủ đơn hàng
                </th>

                <th>
                    Số điện thoại
                </th>

                <th>
                    Địa chỉ
                </th>

                <th>
                    Tình trạng
                </th>

                <th>
                    Ngày mua
                </th>

            </tr>
            </thead>

            <tbody>
             <c:forEach var="bill" items="${listbill}">
                <tr>
                    <th data-bill="${bill.idBill}"> ${bill.customerName}</th>
                    <th data-sodt>${bill.phoneNumber}</th>
                    <th data-diachi>${bill.addressDelivery}</th>
                    <c:if test="${bill.statuss==0}">
                        <th data-tinhtrang=>chờ kiểm duyệt</th>
                    </c:if>
                    <th data-ngaymua>${bill.dateFounded}</th>
                    <th data-id=><a class="btn btn-success btn-capnhathoadon">Cập nhật</a><a class="btn btn-warning btn-xoahoadon">Xóa</a></th>
                </tr>
             </c:forEach>
            </tbody>
        </table>

        <div id="phantrangsanpham" data-tongsotrang="">
        </div>
    </div>
</div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function ()
    {
        var idBill;
        $("body").on("click",".btn-capnhathoadon",function ()
        {
            idBill= $(this).closest("tr").find("th").attr("data-bill");
            $.ajax({
                url:"/ajax/detailbill",
                type:"GET",
                data:
                    {
                        idBill:idBill
                    },
                success:function (value)
                {
                    var table=$('#table');
                    table.empty();
                    table.append(value);
                    var select=$('#sl_tinhtranghoadon option:selected').attr("data-option");
                    if(select=="0")
                    {
                        $('#sl_tinhtranghoadon').val("chờ kiểm duyệt").change();

                    }
                    else if(select=="1")
                    {
                        $('#sl_tinhtranghoadon').val("đã hủy").change();

                    }
                    else if(select=="2")
                    {
                        $('#sl_tinhtranghoadon').val("đang giao hàng").change();

                    }
                    else if(select=="3")
                    {
                        $('#sl_tinhtranghoadon').val("hoàn thành").change();

                    }
                }
            });
        })
        $("#btnInDonHang").click(function ()
        {
            swal("orders", "Save Orders !", "success");
            var status=$('#sl_tinhtranghoadon option:selected').text();
            var currentStatus;

            if(status=="chờ kiểm duyệt")
            {
                currentStatus=0;
            }
            else if(status=="đã hủy")
            {
                currentStatus=1
            }
            else if(status=="đang giao hàng")
            {
                currentStatus=2;
            }
            else if(status=="hoàn thành")
            {
                currentStatus=3;
            }
            $.ajax({
                url:"/ajax/updatebills",
                type:"GET",
                data:{
                    idBill:idBill,
                    currentStatus:currentStatus

                },
                success: function(value)
                {

                }
            })
            if(status!="chờ kiểm duyệt" && status!="đã hủy" )
                {
                    $(".detail-product").each(function()
                    {
                        var idDetailPoduct=$(this).attr("data-id");
                        var amount=$(this).text();
                        $.ajax({
                            url:"/ajax/updatedetail",
                            type:"GET",
                            data:{
                                idDetailPoduct:idDetailPoduct,
                                amount:amount

                            },
                            success: function(value)
                            {

                            }
                        })
                    })
                }

        })
    })
</script>
