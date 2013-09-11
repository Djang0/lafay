package be.lreenaers.lafay.interfaces;

public interface Deletable<T> {
	public void delete (T entity);
	public void deleteRelatedAncestors(T entity);
}
