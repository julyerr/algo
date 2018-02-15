public class 狗年祝福 {
    final String[] 需要祝福的人 = new String[]{"亲戚长辈", "朋友同学", "所有好心的人"};

    public static void main(String[] args) {
        狗年祝福 julyerr的新年祝福 = new 狗年祝福();
        julyerr的新年祝福.送祝福();
        julyerr的新年祝福.送春联();
    }

    private void 送春联() {
        System.out.println("\n\n对联一副\n" +
                "笙歌间错华筵启。喜新春新岁。菜传纤手，青丝轻细。和气入、东风里。\n" +
                "幡儿胜儿都姑媂。戴得更忔戏。愿新春以后，吉吉利利，百事都如意。");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private void 送祝福() {
        for (int i = 0; i < 需要祝福的人.length; i++) {
            switch (需要祝福的人[i]) {
                case "亲戚长辈":
                    System.out.println("亲戚长辈:\n" +
                            "\t在这里，给亲戚长辈们拜年了，祝您新年快乐!万事如意!在新的一年里身体健康!事业有成!芝麻开花节节高!\n");
                    break;
                case "朋友同学":
                    System.out.println("朋友同学\n"+"\t新年到了，想想没什么送给你的，又不打算给你太多，" +
                            "只有给你五千万：千万快乐！千万要健康！千万要平安！千万要知足！千万不要忘记我！");
                    break;
                default:
                    System.out.println("\n所有的好心人\n" +
                            "\t男生像 Oracle 般健壮；\n" +
                            "\t女生像 Vista 般漂亮；\n" +
                            "\t桃花运像 IE 中毒般频繁；\n" +
                            "\t钱包如 Gmail 容量般壮大；\n" +
                            "\t升职速度赶上微软打补丁；\n" +
                            "\t追女朋友像木马一样猖獗；\n" +
                            "\t生活像重装电脑后一样幸福；\n" +
                            "\t写程序敲代码和看小电影一样有激情。");
            }
        }
    }
}
