package question_one;

public class QuestionOne {

    public static void main(String[] args) {
        int[] V = {12, 5, 18, 7, 19, 8, 10};

        int resultRecursive = LongestIncreasingSubsequence.findLIS(V);
        int resultDynamic = LongestIncreasingSubsequence.longestIncreasingSubsequence(V);

        System.out.println("The longest increasing sub sequence (recursive) --> " + resultRecursive);
        System.out.println("The longest increasing sub sequence (dynamic)  --> " + resultDynamic);

        // הסברים - תיעוד של המטלה
        StringBuilder sb = new StringBuilder();

        sb.append("פתרון שאלה: תת-סדרה עולה ממש (Longest Increasing Subsequence)\n");
        sb.append("-----------------------------------------------------------\n\n");

        sb.append("א. הגדרת תת-הבעיה:\n");
        sb.append("T[i] = האורך של תת-הסדרה העולה הארוכה ביותר שמסתיימת באיבר V[i].\n");
        sb.append("במילים אחרות, אנו מחשבים לכל אינדקס i את האורך של תת-הסדרה העולה הארוכה ביותר מבין V[0..i], כאשר היא מסתיימת ב-V[i].\n\n");

        sb.append("ב. נוסחת נסיגה:\n");
        sb.append("T[0] = 1\n");
        sb.append("T[i] = 1 + max { T[j] | j < i && V[j] < V[i] }\n");
        sb.append("אם אין j מתאים, אז T[i] = 1 בלבד (כל איבר לבדו מהווה סדרה באורך 1).\n\n");

        sb.append("ג. אלגוריתם תכנון דינמי:\n");
        sb.append("האלגוריתם עובר על כל איבר במערך, ולכל i בודק את כל j < i ומחשב את הערך האופטימלי ל-T[i] על פי הנוסחה.\n");
        sb.append("לסיום, האלגוריתם מחזיר את הערך המקסימלי מכל תאי T - כלומר אורך תת-הסדרה העולה הארוכה ביותר.\n\n");

        sb.append("ד. ניתוח סיבוכיות:\n");
        sb.append("זמן ריצה: O(n^2) – מאחר ועבור כל איבר i מבוצרת לולאה פנימית על כל איברי j < i.\n");
        sb.append("זיכרון: O(n) – נדרש מערך עזר בגודל n לשמירת תוצאות הביניים (dp / memoization).\n");

        System.out.println("\n" + sb);
    }

}
