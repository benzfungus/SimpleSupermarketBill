/**
 * Created by yaling.he on 2015/11/17.
 */

//供应商管理页面上点击删除按钮弹出删除框(providerList.html)
$(function () {
    $('.removeProvider').click(function () {
    	var b = $(this).attr('name');
        $('.zhezhao').css('display', 'block');
        $('#deleteProviderYes').attr('href', 'deleteProvider?id='+b);
        $('#removeProv').fadeIn();
    });
});

$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeProv').fadeOut();
    });
});


//订单管理页面上点击删除按钮弹出删除框(billList.html)
$(function () {
    $('.removeBill').click(function () {
    	var b = $(this).attr('name');
        $('.zhezhao').css('display', 'block');
        $('#deleteBillYes').attr('href', 'deleteBill?id='+b);
        $('#removeBi').fadeIn();
    });
});

$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeBi').fadeOut();
    });
});

//用户管理页面上点击删除按钮弹出删除框(userList.html)

$(function () {
    $('.removeUser').click(function () {
    	var b = $(this).attr('name');
        $('.zhezhao').css('display', 'block');
        $('#deleteUserYes').attr('href', 'deleteUser?id='+b);
        $('#removeUse').fadeIn();
    });
});

$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeUse').fadeOut();
    });
});
