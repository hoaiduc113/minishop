<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="container-fluid">
    <div class="side-body">
        <div>
            <a class="btn-hienthithemsanpham btn btn-success">Thêm sản phẩm</a>
            <a class="btn-hienthidanhsachsanpham btn btn-success">Hiển thị danh sách sản phẩm</a>
        </div>
        <div class="anbutton">
            <div class="page-title form-style">
                <span class="title">Sản phẩm</span>
                <div class="description">Quản lý nội dung liên tới sản phẩm</div>

                <table class="themsanpham" cellspacing="10" cellpadding="10">
                    <tr>
                        <th>
                            <label for="ip_tensanpham">Tên sản phẩm</label>
                            <input type="text" class="form-control" id="ip_tensanpham" placeholder="Nhập tên sản phẩm" />
                        </th>
                    </tr>
                    <tr>
                        <th>
                            <label for="ip_giasanpham">Giá sản phẩm</label>
                            <input type="number" class="form-control" id="ip_giasanpham" placeholder="Nhập giá sản phẩm" />
                        </th>

                    </tr>
                    <tr>

                        <th>
                            <!-- <label for="sl_loaisanpham">Loại sản phẩm</label></br> -->
                            <select id="sl_loaisanpham" data-minimum-results-for-search="Infinity">
                                <option >Không</option>
                                <option >sơ mi</option>

                            </select>
                        </th>

                        <th rowspan="2">
                            <label for="ip_thongtin">Mô tả</label>
                            <textarea rows="10" id="ip_thongtin" class="form-control"></textarea>
                        </th>


                    </tr>



                    <tr>
                        <th id="khunganhlon">
                            <label for="ip_anhlon">Ảnh lớn</label>
                            <div class="form-group">
                                <input id="ip_anhlon" name="ip_anhlon" class="file" type="file" data-preview-file-type="any" data-upload-url="uploadhinh.php">

                            </div>


                        </th>
                    </tr>

                    <tr>
                        <th id="khunganhnho">
                            <label for="ip_anhnho">Ảnh nhỏ</label>
                            <div class="form-group">
                                <input id="ip_anhnho" name="ip_anhnho" class="file" type="file" multiple data-preview-file-type="any" data-upload-url="uploadhinh.php">
                            </div>
                        </th>
                    </tr>
                </table>


                <div id="containerdetail" >
                    <div class="themchitiet">
                        <table>

                            <tr>
                                <th >
                                    Size: <input  class="sizeproduct" type="text"  />

                                </th>


                                <th style="padding-left:30px">
                                    Màu : <input class="colorproduct" type="text"  />


                                </th>
                                <th style="padding-left:30px">
                                    Số lượng : <input class="amountproduct" type="number"  />
                                    <a class="btn btn-primary  btnthemchitietsanpham">Thêm</a> <a class="btn btn-danger btnhide anbutton btnxoachitietsanpham">Xóa</a>

                                </th>
                            </tr>

                        </table>
                    </div>
                </div>
                <input type="button" class="btn btn-success" id="btn-themsanpham" value="Đồng ý">
                <input type="button" class="btn btn-success" id="btn-capnhatsanpham" value="Cập nhật">

                <div class="thongbaoloi"></div>


            </div>
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
                            Hình
                        </th>

                        <th>
                            Tên sản phẩm
                        </th>

                        <th>
                            Loại sản phẩm
                        </th>

                        <th>
                            Thương hiệu
                        </th>

                        <th>
                            Giá
                        </th>

                        <th>
                            Số lượng
                        </th>

                        <th>
                            #
                        </th>

                    </tr>
                    </thead>

                    <tbody>
                    </tbody>
                </table>

                <div id="phantrangsanpham" data-tongsotrang=>

                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">
    $(document).ready(function ()
    {
        //tinymce của mô tả sản phẩm
        tinymce.init({
            selector: "textarea#ip_thongtin",
            height: 250,
            plugins: [
                'advlist autolink lists link image charmap print preview anchor',
                'searchreplace visualblocks code fullscreen',
                'insertdatetime media table contextmenu paste code'
            ],
            toolbar: 'insertfile undo redo  | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
        });

    })
</script>