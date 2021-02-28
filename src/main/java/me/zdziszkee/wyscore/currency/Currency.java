package me.zdziszkee.wyscore.currency;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Currency {
   private final CurrencyType currencyType;
   private int value;
}
