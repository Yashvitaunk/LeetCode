import java.util.*;

class Solution {

    public String simplifyPath(String path) {

        Stack<String> st = new Stack<>();

        String[] dirs = path.split("/");

        for (String dir : dirs) {

            if (dir.equals("") || dir.equals(".")) {
                continue;
            }

            else if (dir.equals("..")) {

                if (!st.isEmpty())
                    st.pop();
            }

            else {
                st.push(dir);
            }
        }

        if (st.isEmpty())
            return "/";

        StringBuilder res = new StringBuilder();

        for (String dir : st)
            res.append("/").append(dir);

        return res.toString();
    }
}