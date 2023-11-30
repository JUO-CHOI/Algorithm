class Solution {

    public static String solution(String new_id) {
        KaKaoID new_ID = new KaKaoID(new_id);

        // 객체지향프로그래밍 구현 -> 메소드 체이닝
        return new_ID
                .toLowerCase()
                .filter()
                .doubleDotFilter()
                .firstOrLastDotFilter()
                .isEmptyFillA()
                .subString()
                .addString()
                .getId();
    }

    public static class KaKaoID {

        String id;
        public KaKaoID(String id) {
            this.id = id;
        }

        // #1
        public KaKaoID toLowerCase() {
            id = id.toLowerCase();
            return this;
        }

        // #2
        public KaKaoID filter() {
            id = id.replaceAll("[^a-z0-9-_.]", "");
            return this;
        }

        // #3
        public KaKaoID doubleDotFilter() {
            id = id.replaceAll("[.]{2,}", ".");
            return this;
        }

        // #4
        public KaKaoID firstOrLastDotFilter() {
            if (id.charAt(0) == '.')
                id = id.substring(1);
            if (!id.isEmpty() && id.charAt(id.length() - 1) == '.')
                id = id.substring(0,id.length() - 1);
            return this;
        }

        // #5
        public KaKaoID isEmptyFillA() {
            if (id.isEmpty())
                id = "a";
            return this;
        }

        // #6
        public KaKaoID subString() {
            if (id.length() > 15)
                id = id.substring(0,15);
            if (id.length() == 15 && id.charAt(14) == '.')
                id = id.substring(0,14);
            return this;
        }

        // #7
        public KaKaoID addString() {
            StringBuilder sb = new StringBuilder(id);
            if (id.length() < 3) {
                while (true) {
                    sb = sb.append(sb.charAt(sb.length() - 1));
                    if (sb.length() == 3) break;
                }
            }
            id = sb.toString();
            return this;
        }

        public String getId() {
            return id;
        }

    }

}
