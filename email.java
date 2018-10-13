public class email {
    public static String[] emails = new String[]{"aasd+b@example.com","dupli......cate@example.com","d.u.p.l.i.c.a.t.e@example.com"};. 一亩-三分-地，独家发布
    public static int solution2(String[] emails){
        if(emails == null || emails.length == 0) return 0;
        int answer = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(String s: emails){
            char[] emailchar = s.toCharArray();
            int count = 0;
            for(int i = 0; i < emailchar.length;i++){
                if(emailchar == '+'){
                    while(i != '@'){
                        i++;
                    }
                    while(i < emailchar.length){
                        emailchar[count++] = emailchar[i++];
                    }
                }
                else if(emailchar == '.'){
                    while(emailchar == '.'){
                    emailchar[count] = emailchar[++i];
                }
                }


            }
            String email = new String(emailchar);
            if(!map.containsKey(email)){
                map.put(email,1);
            }
            else{
                map.put(email,map.get(email)+1);
            }

        }
        for(int num : map.values()){
            if(num > 1) answer++;
        }
        for(String str: map.keySet()){
            System.out.println(str);
        }
        return answer;
    }

    public static void main(String[] args) {

        int a = test.solution(emails);
        System.out.println(a);
        System.out.println(11);
    }
}