/**
 * Created by elvin
 */
function banThis(obj,text){
    if(obj.css('cursor') == 'not-allowed'){
        return false;
    }else{
        obj.css('cursor','not-allowed');
        obj.html(text);
        return true;
    }
}
function freeThis(obj,text){
    obj.css('cursor','pointer');
    obj.html(text);
}