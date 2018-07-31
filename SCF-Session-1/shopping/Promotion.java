package shopping;

import java.util.Date;

public interface Promotion {

	public double getMinimumPrice();

	public void setMinimumPrice(double minimumPrice);

	public double getFixedDiscount();

	public void setFixedDiscount(double discount);

	public boolean isPromotionApplicable(String code);
}

class FixedProductPromotion implements Promotion {
	double minimumPrice, discount;

	@Override
	public double getMinimumPrice() {
		return minimumPrice;
	}

	@Override
	public void setMinimumPrice(double minimumPrice) {
		this.minimumPrice = minimumPrice;

	}

	@Override
	public double getFixedDiscount() {
		return discount;
	}

	@Override
	public void setFixedDiscount(double discount) {
		this.discount = discount;

	}

	/**
	 * This method checks if the promotion can be applied based on the promocode
	 * provided by the user
	 * 
	 * @param code
	 *            contains the promocode as provided by the user
	 * @return returns true if promotion can be applied else return false
	 */
	@Override
	public boolean isPromotionApplicable(String code) {
		Date currentDate = new Date();
		boolean result = false;

		for (Promocode promotion : Promocode.values()) {
			if (code.equals(promotion.getCode())) {
				if (currentDate.after(promotion.getStartDate().getTime())
						&& currentDate.before(promotion.getEndDate().getTime()))
					result = true;
				else
					result = false;
			}
		}
		return result;
	}
}

class FixedOrderPromotion implements Promotion {
	double minimumPrice, discount;

	@Override
	public double getMinimumPrice() {
		return minimumPrice;
	}

	@Override
	public void setMinimumPrice(double minimumPrice) {
		this.minimumPrice = minimumPrice;

	}

	@Override
	public double getFixedDiscount() {
		return discount;
	}

	@Override
	public void setFixedDiscount(double discount) {
		this.discount = discount;
	}

	/**
	 * This method checks if the promotion can be applied based on the promocode
	 * provided by the user
	 * 
	 * @param code
	 *            contains the promocode as provided by the user
	 * @return returns true if promotion can be applied else returns false
	 */
	@Override
	public boolean isPromotionApplicable(String code) {
		Date currentDate = new Date();
		boolean result = false;

		for (Promocode promo : Promocode.values()) {
			if (code.equals(promo.getCode())) {
				if (currentDate.after(promo.getStartDate().getTime())
						&& currentDate.before(promo.getEndDate().getTime()))
					result = true;
				else
					result = false;
			}
		}
		return result;
	}
}