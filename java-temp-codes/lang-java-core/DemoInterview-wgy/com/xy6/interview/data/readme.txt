����˰����

��������˰��������Ʒ���գ�˰����10%�������鼮��ʳƷ��ҩƷ����������
����˰�������н�����Ʒ���յĶ����˰��˰��5%��û�н�����Ʒ������������˰��
��һ���˿Ͳɹ���Ʒʱ�������յ�һ���վݣ������г�������Ʒ���ܼۣ��Լ�ȫ��Ӧ����˰�ѡ�
˰����Ҫ�����뵽5�֣�0.05Ԫ�������磬3.14Ӧ���������3.15, 2.48Ӧ���������2.50,
3.01�������3.05��
����
��Ҫ��ʵ�ּ����һ�ݶ�����������Ʒ����˰����ܼ۵Ĺ��ܡ�.

1	��ʵ��Program.cs��calculateResult()������
2	�봴����Ҫ������ʵ��������ܡ����ʵ��Ӧ�÷������������Ƶ�ԭ��
3	��Ĵ������ͨ��ȫ������������  ���������Ѿ��������ĵ��У��벻Ҫ�޸ġ�
4	���ʱ���������Ŀ���չ�ԡ�ҵ��Ҫ����ܻ��иı䣬������˰����ƷƷ�ֿ������ӣ�
	  �������µ�˰�֡�����ϣ�����ʵ�ֶ����д�����������С�ĸı����֧����Щ��չ��

2.   case1.xml ��
<?xml version="1.0" encoding="utf-8" ?>
<testCase name="testCase1">
    <items>
      <item name="book" count="1" unitPrice="12.49" type="book" imported="false"></item>
      <item name="music CD" count="1" unitPrice="14.99" type="av" imported="false"></item>
      <item name="chocolate bar" count="1" unitPrice="0.85" type="food" imported="false"></item>
    </items>
    <result taxes="1.50" total="29.83"></result>
</testCase>

3.  case2.xml��

<?xml version="1.0" encoding="utf-8" ?>
<testCase name="testCase2">
  <items>
    <item name="box of chocolates" count="1" unitPrice="10.00" type="food" imported="true"></item>
    <item name="bottle of perfume" count="1" unitPrice="47.50" type="makeup" imported="true"></item>
  </items>
  <result taxes="7.65" total="65.15"></result>
</testCase>

4.    case3.xml��

<?xml version="1.0" encoding="utf-8" ?>
<testCase name="testCase3">
  <items>
    <item name="bottle of perfume" count="1" unitPrice="27.99" type="makeup" imported="true"></item>
    <item name="bottle of perfume" count="1" unitPrice="18.99" type="makeup" imported="false"></item>
    <item name="packet of headache pills" count="1" unitPrice="9.75" type="medical" imported="false"></item>
    <item name="box of chocolates" count="1" unitPrice="11.25" type="food" imported="true"></item>
  </items>
  <result taxes="6.70" total="74.68"></result>
</testCase>