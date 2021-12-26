package educative.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Trace the complete path of a journey
 */
public class TraceCompletePath {

    static String traceCompletePath(Map<String,String> tripMap){
        Map<String ,String> reverseMap = tripMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue,Map.Entry::getKey));

        String from = "";

        for(Map.Entry<String,String> entry : tripMap.entrySet()){
            if(!reverseMap.containsKey(entry.getKey())){
                from = entry.getKey();
            }
        }

        String to = tripMap.get(from);
        String res = "";
        while(to!=null){
            res += from+" -> "+to + ", ";
            from = to;
            to = tripMap.get(to);

        }

        return res;
    }

    public static void main(String[] args) {
        HashMap<String,String> hMap = new HashMap<>();

        hMap.put("NewYork","Chicago");
        hMap.put("Boston","Texas");
        hMap.put("Missouri","NewYork");
        hMap.put("Texas","Missouri");

        String actual_output = TraceCompletePath.traceCompletePath(hMap);

        System.out.println(actual_output);
    }

}
