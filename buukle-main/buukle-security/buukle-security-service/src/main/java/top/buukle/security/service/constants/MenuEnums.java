package top.buukle.security .service.constants;

/**
 * @Author: elvin
 * @Date: 2019/7/28/028 3:56
 */
public class MenuEnums {

    public enum status {

        DELETED(-1,"已经删除"),
        INIT(0,"初始化"),
        HANDLING(1,"处理中"),
        REJECT(2,"审核不通过"),
        PUBLISED(3,"审核通过"),
        BAN(4,"已被封禁"),
        ;

        private Integer status;
        private String description;

        status(int status, String description) {
            this.description = description;
            this.status = status;
        }
        public String getDescription() {
            return description;
        }
        public Integer value() {
            return status;
        }
    }
    public enum display {

        DISPLAY_NONE(0,"不展示"),
        DISPLAY_BLOCK(1,"展示"),
        ;

        private Integer code;
        private String description;

        display(int code, String description) {
            this.description = description;
            this.code = code;
        }
        public String getDescription() {
            return description;
        }
        public Integer value() {
            return code;
        }
    }
    public enum type {

        MENU(1,"菜单"),
        COMPONENT(0,"组件"),
        ;

        private Integer code;
        private String description;

        type(int code, String description) {
            this.description = description;
            this.code = code;
        }
        public String getDescription() {
            return description;
        }
        public Integer value() {
            return code;
        }
    }
}
