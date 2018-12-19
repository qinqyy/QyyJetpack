package com.example.qyy.mydatabinding.bean;

public class Pojo {
    public PP getPp() {
        return pp;
    }

    public void setPp(PP pp) {
        this.pp = pp;
    }

    private PP pp;

    public static class PP {
        public QQ getQq() {
            return qq;
        }

        public void setQq(QQ qq) {
            this.qq = qq;
        }

        private QQ qq;

        private String bh;

        public String getBh() {
            return bh;
        }

        public void setBh(String bh) {
            this.bh = bh;
        }

        public static class QQ {
            private String cc;

            public String getCc() {
                return cc;
            }

            public void setCc(String cc) {
                this.cc = cc;
            }
        }

    }
}
