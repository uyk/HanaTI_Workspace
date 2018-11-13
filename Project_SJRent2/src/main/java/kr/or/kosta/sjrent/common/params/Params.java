package kr.or.kosta.sjrent.common.params;

public class Params {
	
	private int page;            /** 사용자 선택 페이지 */
	private int listSize;        /** 조회 목록 개수 */
	private int pageSize;        /** 출력 페이지 개수 */
	private String searchType;   /** 검색 유형 */
	private String searchValue;  /** 검색 값 */
	
	public Params() {
		this(1, 15, 5, null, null);
	}
	
	public Params(int page, int listSize, String searchType, String searchValue) {
		this(page, listSize, 5, null, null);
	}
	
	public Params(int page, int listSize, int pageSize, String searchType, String searchValue) {
		this.page = page;
		this.listSize = listSize;
		this.pageSize = pageSize;
		this.searchType = searchType;
		this.searchValue = searchValue;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	@Override
	public String toString() {
		return "Params [page=" + page + ", listSize=" + listSize + ", pageSize=" + pageSize + ", searchType="
				+ searchType + ", searchValue=" + searchValue + "]";
	}
}
