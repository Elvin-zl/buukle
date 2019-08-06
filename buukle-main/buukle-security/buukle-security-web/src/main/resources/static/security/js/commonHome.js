$(function () {
    // 初始化静态多选下拉框
    loadMulti();
    // 初始化动态异步模糊搜索下拉框
    loadFuzzySearch();
    // 加载第一页
    loadFirstPage();
    // 绑定清空
    bindClear();
    // 绑定刷新
    bindRefresh();
});
/** 绑定刷新*/
function bindRefresh() {
    $('#refresh').off().on('click',function () {
        loadPage($('#page').val());
        doPage();
    })
}
/** 初始化静态多选下拉框*/
function loadMulti() {
    var multiSelects = $('.multiSelect');
    $.each(multiSelects, function (i, obj) {
        $(obj).select2({placeholder:$(obj).attr('data-multiHolder')});
    })
}
/** 绑定清空*/
function bindClear() {
    $('#clear').off().on('click',function () {
        $('.clearAble').val('');
        loadMulti();
        loadFuzzySearch();
    })
}
/** 加载第一页*/
function loadFirstPage() {
    document.getElementById("shadow").style.display ="block";
    $('#table-list').load($('#table-list').attr('data-url'),function () {
        initCommonPage();
        document.getElementById("shadow").style.display ="none";
    });
}
/**
 * 初始化动态异步模糊搜索下拉框
 * 使用方式 :
 * step 1 :在页面html的搜索form下添加宿主dom, 例 :
 *  <select class="fuzzy clearAble" name="nameCn" data-fieldName="name_cn" data-isIdVisual="0" style="width: 200px;height: 10px">
 *      <option value="">请输入账号</option>
 *  </select>
 *  其中: <1> class 固定的 .fuzzy clearAble ;
 *       <2> [name] 要模糊搜索的属性名, [data-fieldName] 要模糊搜索的数据库字段名;
 *       <3> [data-isIdVisual] 为是否在结果中显示该条记录的id值,用以区分相同的情况;
 * step 2 : 在mapper.xml文件中,补充模糊搜素的sql :
 *  (1) : 写sql
 *  <select id="fuzzySearch" parameterType="top.buukle.common.call.vo.FuzzyVo" resultMap="FuzzyResultMap">
 *      select id, ${fieldName} from user where ${fieldName}  like '%${text}%';
 *  </select>
 *  (2) : 写FuzzyResultMap
 *  将新增的模糊搜索字段分别写 <result column="新增的段名" jdbcType="VARCHAR" property="id" /><result column="新增的段名" jdbcType="VARCHAR" property="text" />
 *  <resultMap id="FuzzyResultMap" type="top.buukle.common.call.vo.FuzzyVo">
 *      <id column="id" jdbcType="INTEGER" property="identity" />
 *      <result column="username" jdbcType="VARCHAR" property="id" />
 *      <result column="username" jdbcType="VARCHAR" property="text" />
 *
 *     <result column="name_cn" jdbcType="VARCHAR" property="id" />
 *      <result column="name_cn" jdbcType="VARCHAR" property="text" />
 *  </resultMap>
 */
function loadFuzzySearch() {
    var fuzzys = $('.fuzzy');
    $.each(fuzzys, function (i, obj) {
        $(obj).select2({
            allowClear: true,
            minimumInputLength:$(obj).attr('data-minimum'),
            id: function(data) {
                return data.id
            },
            formatSelection: function (data) { return data.text },
            ajax: {
                type:'get',
                url: function(params){
                    return  $(this).attr('data-url')+'?fieldName=' + $(obj).attr('data-fieldName');
                },
                dataType:'json',
                //输入的内容
                data: function(params) {
                    return {
                        text:params.term,
                    }
                },
                processResults: function (data, page) {
                    if(data.head.status == "S"){
                        return {
                            results: data.body.data
                        };
                    }else{
                        layer.msg('查询异常!');
                    }
                },
                cache: true,
            },
            placeholder:'请输入相应字段值',
            //提示语
            escapeMarkup: function(markup) {
                return markup
            },
            templateResult: formatResult,
            templateSelection: formatRepoSelection
        });
        function formatResult (data) {
            if (data.loading) {
                return data.text;
            }

            var markup = "<div class='select2-result-repository clearfix'>" +
                "<div class='select2-result-repository__meta'>" ;
            if($(obj).attr('data-isIdVisual') == 1){
                if(data.userId !=null && data.userId !=""){
                    // 显示userId
                    markup += "<div class='select2-result-repository__title'>" + data.id+"("+ data.userId + ")" + "</div>";
                }else{
                    // 显示记录的主键id
                    markup += "<div class='select2-result-repository__title'>" + data.id+"("+ data.identity + ")" + "</div>";
                }
            }else{
                markup += "<div class='select2-result-repository__title'>" + data.id +"</div>";
            }
            if (data.description) {
                markup += "<div class='select2-result-repository__description'>" + data.id + "</div>";
            }
            return markup;
        }
        function formatRepoSelection (repo) {
            return repo.text;
        }
    });
}