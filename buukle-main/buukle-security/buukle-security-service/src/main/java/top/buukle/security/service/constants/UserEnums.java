package top.buukle.security .service.constants;

/**
 * @Author: elvin
 * @Date: 2019/7/28/028 3:56
 */
public class UserEnums {

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
    public enum superManager {

        SUPER_MANAGER(1,"是超管"),
        SYSTEM_MANAGER(0,"系统保护数据"),
        ;

        private Integer superManager;
        private String description;

        superManager(int superManager, String description) {
            this.description = description;
            this.superManager = superManager;
        }
        public String getDescription() {
            return description;
        }
        public Integer value() {
            return superManager;
        }
    }
}
