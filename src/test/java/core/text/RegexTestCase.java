package core.text;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class RegexTestCase {

    @Test
    public void testRegex3() {

        String textBody = "value=\"[xxxRegNamexxx]\">" +
                "[xxxSEGMENT_11112222xxx] [xxxSEGMENT_22221111xxx]";
        Set<Long> set = detectBodyHtmlMergeFieldSegmentIds(textBody);
        set.stream().forEach(System.out::println);
    }

    public Set<Long> detectBodyHtmlMergeFieldSegmentIds(String bodyHtml) {
        Pattern MERGE_FIELD_PATTERN2 = Pattern.compile("\\[xxxSEGMENT_(\\d+)xxx\\]");
        Matcher matcher = MERGE_FIELD_PATTERN2.matcher(bodyHtml);
        Set<Long> mergeFieldQuestionIdSet = new HashSet<Long>();

        while (matcher.find()) {
            String customQuestionIDstr = matcher.group(1);

            if (Objects.isNull(customQuestionIDstr)) {
                //should never happen
                continue;
            }

            mergeFieldQuestionIdSet.add(Long.valueOf(customQuestionIDstr));
        }

        return mergeFieldQuestionIdSet;
    }

    @Test
    public void testRegex2() {
//        Pattern MERGE_FIELD_PATTERN = Pattern.compile("\\[xxx([^\\[\\]]+)xxx\\]");
        Pattern MERGE_FIELD_PATTERN2 = Pattern.compile("\\[xxxSEGMENT - (\\d+)xxx\\]");

        String textBody = "value=\"[xxxregistrationSessionNamexxx]\">" +
                "[xxxSEGMENT - 669729471511xxx]";

        Matcher matcher = MERGE_FIELD_PATTERN2.matcher(textBody);

        while (matcher.find()) {
            String qid = matcher.group(1);
            System.out.println(qid);
        }
    }

    @Test
    public void testRegex() {
        Pattern MERGE_FIELD_PATTERN = Pattern.compile("\\[xxx([^\\[\\]]+)xxx\\]");
        String textBody = "value=\"[xxxregistrationSessionNamexxx]\">" +
                "[xxxSEGMENT - 669729471511xxx]";

        Pattern CustomQuestionPattern = Pattern.compile("SEGMENT - (\\d+)");

        Matcher matcher = MERGE_FIELD_PATTERN.matcher(textBody);

        while (matcher.find()) {
            String mergeFieldName = matcher.group(1);
            System.out.println(mergeFieldName);

            Matcher matcher2 = CustomQuestionPattern.matcher(mergeFieldName);
            while (matcher2.find()) {
                String qID = matcher2.group(1);
                System.out.println("[" + qID + "]");
            }

        }

    }
}
