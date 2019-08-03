package top.buukle.cms.service.constants;

/**
 * @Author: jyj
 * @Date: 2019/7/28/028 3:56
 */
public class ArticleEnums {

    public enum status {

        INIT(0,"初始化"),
        HANDLING(1,"处理中"),
        REJECT(2,"审核不通过"),
        PUBLISED(3,"审核通过"),
        DELETED(4,"已经删除"),
        BAN(5,"已被封禁"),
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
}
