package test.com.xy6.interview;

import java.math.BigDecimal;
import java.util.ArrayList;

import junit.framework.TestCase;

import com.xy6.interview.ProductForm;

public class TestProductFormHelper extends TestCase {

	public boolean bCalced = false;

	public ProductForm getCase1Form1(){
		ProductForm form = new ProductForm();
		form.setName("book");
		form.setCount(1);
		form.setUnitPrice(new BigDecimal("12.49"));
		form.setType("book");
		form.setImported(false);
		if(bCalced){
			form.setItemPrice(new BigDecimal("12.49"));
			form.setItemTax(new BigDecimal("0.00"));
		} else{
			form.setItemPrice(new BigDecimal("0.00"));
			form.setItemTax(new BigDecimal("0.00"));
		}

		return form;
	}

	public ProductForm getCase1Form2(){
		ProductForm form = new ProductForm();
		form.setName("music CD");
		form.setCount(1);
		form.setUnitPrice(new BigDecimal("14.99"));
		form.setType("av");
		form.setImported(false);
		if(bCalced){
			form.setItemPrice(new BigDecimal("14.99"));
			form.setItemTax(new BigDecimal("1.50"));
		} else{
			form.setItemPrice(new BigDecimal("0.00"));
			form.setItemTax(new BigDecimal("0.00"));
		}

		return form;
	}

	public ProductForm getCase1Form3(){
		ProductForm form = new ProductForm();
		form.setName("chocolate bar");
		form.setCount(1);
		form.setUnitPrice(new BigDecimal("0.85"));
		form.setType("food");
		form.setImported(false);
		if(bCalced){
			form.setItemPrice(new BigDecimal("0.85"));
			form.setItemTax(new BigDecimal("0.00"));
		} else{
			form.setItemPrice(new BigDecimal("0.00"));
			form.setItemTax(new BigDecimal("0.00"));
		}
		return form;
	}

	public ProductForm getCase2Form1(){
		ProductForm form = new ProductForm();
		form.setName("box of chocolates");
		form.setCount(1);
		form.setUnitPrice(new BigDecimal("10.00"));
		form.setType("food");
		form.setImported(true);
		if(bCalced){
			form.setItemPrice(new BigDecimal("10.00"));
			form.setItemTax(new BigDecimal("0.50"));
		} else{
			form.setItemPrice(new BigDecimal("0.00"));
			form.setItemTax(new BigDecimal("0.00"));
		}

		return form;
	}

	public ProductForm getCase2Form2(){
		ProductForm form = new ProductForm();
		form.setName("bottle of perfume");
		form.setCount(1);
		form.setUnitPrice(new BigDecimal("47.50"));
		form.setType("makeup");
		form.setImported(true);
		if(bCalced){
			form.setItemPrice(new BigDecimal("47.50"));
			form.setItemTax(new BigDecimal("7.15"));
		} else{
			form.setItemPrice(new BigDecimal("0.00"));
			form.setItemTax(new BigDecimal("0.00"));
		}

		return form;
	}

	public ProductForm getCase3Form1(){
		ProductForm form = new ProductForm();
		form.setName("bottle of perfume");
		form.setCount(1);
		form.setUnitPrice(new BigDecimal("27.99"));
		form.setType("makeup");
		form.setImported(true);
		if(bCalced){
			form.setItemPrice(new BigDecimal("27.99"));
			form.setItemTax(new BigDecimal("4.20"));
		} else{
			form.setItemPrice(new BigDecimal("0.00"));
			form.setItemTax(new BigDecimal("0.00"));
		}

		return form;
	}

	public ProductForm getCase3Form2(){
		ProductForm form = new ProductForm();
		form.setName("bottle of perfume");
		form.setCount(1);
		form.setUnitPrice(new BigDecimal("18.99"));
		form.setType("makeup");
		form.setImported(false);
		if(bCalced){
			form.setItemPrice(new BigDecimal("18.99"));
			form.setItemTax(new BigDecimal("1.90"));
		} else{
			form.setItemPrice(new BigDecimal("0.00"));
			form.setItemTax(new BigDecimal("0.00"));
		}

		return form;
	}

	public ProductForm getCase3Form3(){
		ProductForm form = new ProductForm();
		form.setName("packet of headache pills");
		form.setCount(1);
		form.setUnitPrice(new BigDecimal("9.75"));
		form.setType("medical");
		form.setImported(false);
		if(bCalced){
			form.setItemPrice(new BigDecimal("9.75"));
			form.setItemTax(new BigDecimal("0.00"));
		} else{
			form.setItemPrice(new BigDecimal("0.00"));
			form.setItemTax(new BigDecimal("0.00"));
		}

		return form;
	}

	public ProductForm getCase3Form4(){
		ProductForm form = new ProductForm();
		form.setName("box of chocolates");
		form.setCount(1);
		form.setUnitPrice(new BigDecimal("11.25"));
		form.setType("food");
		form.setImported(true);
		if(bCalced){
			form.setItemPrice(new BigDecimal("11.25"));
			form.setItemTax(new BigDecimal("0.60"));
		} else{
			form.setItemPrice(new BigDecimal("0.00"));
			form.setItemTax(new BigDecimal("0.00"));
		}

		return form;
	}

	public ArrayList<ProductForm> getCase1ListForm(){
		ArrayList<ProductForm> listForm = new ArrayList<ProductForm>();
		listForm.add(this.getCase1Form1());
		listForm.add(this.getCase1Form2());
		listForm.add(this.getCase1Form3());

		return listForm;
	}

	public ArrayList<ProductForm> getCase2ListForm(){
		ArrayList<ProductForm> listForm = new ArrayList<ProductForm>();
		listForm.add(this.getCase2Form1());
		listForm.add(this.getCase2Form2());

		return listForm;
	}

	public ArrayList<ProductForm> getCase3ListForm(){
		ArrayList<ProductForm> listForm = new ArrayList<ProductForm>();
		listForm.add(this.getCase3Form1());
		listForm.add(this.getCase3Form2());
		listForm.add(this.getCase3Form3());
		listForm.add(this.getCase3Form4());

		return listForm;
	}
}
