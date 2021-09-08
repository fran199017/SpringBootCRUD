package com.fran.app.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	
	private String url;
	private Page<T> page;
	private int totalPaginas;
	private int numeroElementos;
	private int paginaActual;
	private List<PageItem> paginas;
	
	public PageRender(String url, Page<T> page) {
		super();
		this.url = url;
		this.page = page;
		this.paginas= new ArrayList<PageItem>();
		
		numeroElementos= page.getSize();
		totalPaginas=page.getTotalPages();
		paginaActual=page.getNumber() +1;
		
		int desde, hasta;
		if(totalPaginas <= numeroElementos) {
			desde=1;
			hasta= totalPaginas;
			
		} else {
			if(paginaActual <= numeroElementos/2) {
				desde=1;
				hasta= numeroElementos;
			}else if(paginaActual >= totalPaginas - numeroElementos/2) {
				desde=totalPaginas - numeroElementos +1;
				hasta= numeroElementos;
			}else {
				desde= paginaActual - numeroElementos/2;
				hasta=numeroElementos;
			}
		}
		for(int i=0; i< hasta; i++) {
			paginas.add(new PageItem(desde+ i, paginaActual==desde+i));
		}
		
	}

	public String getUrl() {
		return url;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public List<PageItem> getPaginas() {
		return paginas;
	} 
	public boolean isFirst() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean isHasNext() {
		return page.hasNext();
	}
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
	
	

}
