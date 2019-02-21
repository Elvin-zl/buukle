/**
 * Created by elvin
 */

var editor = new wangEditor('editor');
editor.config.uploadImgUrl = '/upload';
editor.config.menus = [
    'source',
    '|',     // '|' 是菜单组的分割线
    'bold',
    'underline',
    'italic',
    'strikethrough',
    'head',
    'quote',
    'eraser',
    'forecolor',
    'bgcolor',
    'img',
    'fontsize',
    'fontfamily',
    'redo',
    'undo'
];
editor.create();
