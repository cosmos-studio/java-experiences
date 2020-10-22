package java8.annotation.demo1;

public enum FieldType {
	Null, Integer, Double, String, Object;

	public static FieldType check(Object fieldValue) {
		if (fieldValue == null) {
			return FieldType.Null;
		}

		FieldType type = FieldType.Null;
		if (fieldValue instanceof java.lang.Integer) {
			if ((Integer) fieldValue != 0) {
				type = FieldType.Integer;
			}
		} else if (fieldValue instanceof java.lang.Double) {
			if ((Double) fieldValue != 0) {
				type = FieldType.Double;
			}
		} else if (fieldValue instanceof java.lang.String) {
			type = FieldType.String;
		} else {
			type = FieldType.Object;
		}
		return type;
	}

}
