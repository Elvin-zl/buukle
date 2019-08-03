package top.buukle.common.call;

import top.buukle.common.call.head.ResponseHead;
import top.buukle.common.call.vo.FuzzyVo;

import java.util.List;

/**
 * @Author: 模糊搜索响应
 * @Date: 2019/7/28/028 3:17
 */
public class FuzzyResponse {
    /** 响应头*/
    private ResponseHead head;

    /** 响应体*/
    private Body body;

    FuzzyResponse(List<FuzzyVo> fuzzyVos) {
        this.head = new ResponseHead.Builder().buildSuccess();
        this.body = new Body(fuzzyVos);
    }

    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public static class Builder{

        public FuzzyResponse build(List<FuzzyVo> fuzzyVos) {
            return new FuzzyResponse(fuzzyVos);
        }
    }

    private static class Body{

        private Integer total;
        private List<FuzzyVo> data;

        Body(List<FuzzyVo> fuzzyVos) {
            this.data = fuzzyVos;
            this.total = fuzzyVos == null ? 0 : fuzzyVos.size();
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public List<FuzzyVo> getData() {
            return data;
        }

        public void setData(List<FuzzyVo> data) {
            this.data = data;
        }
    }
}
