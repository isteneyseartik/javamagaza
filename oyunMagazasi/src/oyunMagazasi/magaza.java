package oyunMagazasi;

public class magaza {
	
	public int toplamPara;
	private int adetFiyat;
	private String[] urunler;
	private int[] urunlerID;
	
	public magaza(String[] urunler,int adetFiyat) {
		this.urunler = urunler;
		urunlerID = new int[urunler.length];
		for(int i=0;i<urunler.length;i++) {
			urunlerID[i]= (int)(Math.random()*100)+100;
		}
		this.adetFiyat = adetFiyat;
		toplamPara = urunler.length*adetFiyat;
	}
	public int getAdetFiyat() {
		return adetFiyat;
	}
	private void setAdetFiyat(int adetFiyat) {
		this.adetFiyat = adetFiyat;
		this.toplamPara = adetFiyat*urunler.length;
	}
	
	public void setUrunler(String urunler[]) {
		this.urunler = urunler;
		urunlerID = new int[urunler.length];
		for(int i=0;i<urunler.length;i++) {
			urunlerID[i]= (int)(Math.random()*100)+100;
		}	
	}
	
	public boolean urunAdiVarmi(String urunAdi) {
		for(int i=0;i<urunler.length;i++) {
			if(urunler[i]==urunAdi) {
				return true;
			}
		}
		return false;
	}
	
	public boolean urunIDVarmi(int urunID) {
		for(int i=0;i<urunlerID.length;i++) {
			if(urunlerID[i]==urunID) {
				return true;
			}
		}
		return false;
	}
	
	public void silUrun(int ID) {
		if(urunIDVarmi(ID)){
			int urunIndex=0;
			for(int i=0;i<urunlerID.length;i++) {
				if(ID==urunlerID[i]) {
					urunIndex = i;
					return;
				}
			}
			urunler[urunIndex]="";
			urunlerID[urunIndex]=-1;
		}
		else
		{
			System.err.println("ürün bulunamadý");
		}
	}
	public void silUrun(String urunAdi) {
		if(urunAdiVarmi(urunAdi)){
			int urunIndex=0;
			for(int i=0;i<urunlerID.length;i++) {
				if(urunAdi==urunler[i]) {
					urunIndex = i;
					return;
				}
			}
			urunler[urunIndex]="";
			urunlerID[urunIndex]=-1;
		}
		else
		{
			System.err.println("ürün bulunamadý");
		}
	}
}
class urun extends magaza{
	public urun(String[] urunler, int adetFiyat) {
		super(urunler, adetFiyat);
	}
	
	public void satýs(String urunAdi) {
		if(super.urunAdiVarmi(urunAdi)) {
			super.toplamPara+=super.getAdetFiyat();
			super.silUrun(urunAdi);
		}
	}
	public void satýs(int ID) {
		if(super.urunIDVarmi(ID)) {
			super.toplamPara+=super.getAdetFiyat();
			super.silUrun(ID);
		}
	}
}
