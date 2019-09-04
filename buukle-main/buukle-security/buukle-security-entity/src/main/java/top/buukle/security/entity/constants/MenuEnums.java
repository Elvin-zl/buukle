package top.buukle.security.entity.constants;

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
    public enum systemFlag {

        SYSTEM_PROTECTED(1,"系统保护数据"),
        ;

        private Integer systemFlag;
        private String description;

        systemFlag(int systemFlag, String description) {
            this.description = description;
            this.systemFlag = systemFlag;
        }
        public String getDescription() {
            return description;
        }
        public Integer value() {
            return systemFlag;
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
    public enum positionType {

        LEFT_AND_TOP(1,"左侧和顶部"),
        LEFT_ONLY(0,"仅左侧"),
        ;

        private Integer code;
        private String description;

        positionType(int code, String description) {
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
