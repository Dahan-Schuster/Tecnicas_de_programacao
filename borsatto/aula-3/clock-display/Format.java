public enum Format {
	FULL(24),
	HALF(13);

	public final int rollOverLimit;

	Format(int limit) {
		this.rollOverLimit = limit;
	}
}
