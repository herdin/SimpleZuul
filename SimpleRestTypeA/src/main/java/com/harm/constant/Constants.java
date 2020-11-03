package com.harm.constant;

import com.harm.entity.Account;
import com.harm.entity.CardService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

public class Constants {
    private Constants() { /*do not create instance*/ }
    public static class CARD_SERVICE {
        public enum TYPE {
            INCOME_TAX_DEDUCTION    ("I", "소득공제"),
            MILEAGE                 ("M", "마일리지"),
            LOST_THEFT              ("L", "분실도난"),
            ETC                     ("E", "기타"),
            ;
            String value;
            String desc;
            TYPE(String value, String desc) {
                this.value = value;
                this.desc = desc;
            }
            public String value() { return value; }
            public String desc() { return desc; }
            public static TYPE convert(String value) {
                if(value == null) return null;
                Optional<TYPE> findType = Arrays.stream(TYPE.values())
                        .filter(type -> type.value().equals(value))
                        .findAny();
                return (findType.isPresent())? findType.get():null;
            }
            public static boolean checkType(String value) {
                return TYPE.convert(value) != null;
            }
            public static boolean checkTypes(String ... values) {
                if(values == null || values.length <= 0) return false;
                return Arrays.stream(values).noneMatch(value -> !TYPE.checkType(value));
            }
        }

        public enum ACTION {
            REGISTER("R", "등록") {
                @Override
                public boolean updateService(Account account, TYPE type) {
                    if(account.getRegisteredCardServices().stream().anyMatch(cardService -> cardService.getType().equals(type.value()))) return true;
                    CardService cardService = new CardService();
                    cardService.setType(type.value());
                    cardService.setRegistered(LocalDateTime.now());
                    account.addService(cardService);
                    return true;
                }
            },
            DELETE("D", "삭제") {
                @Override
                public boolean updateService(Account account, TYPE type) {
                    CardService cardService = new CardService();
                    cardService.setType(type.value());
                    account.removeService(cardService);
                    return true;
                }
            },
            ;
            String value;
            String desc;
            ACTION(String value, String desc) {
                this.value = value;
                this.desc = desc;
            }
            public String value() { return value; }
            public String desc() { return desc; }
            public static ACTION convert(String value) {
                if(value == null) return null;
                Optional<ACTION> findAction = Arrays.stream(ACTION.values())
                        .filter(action -> action.value().equals(value))
                        .findAny();
                return (findAction.isPresent())? findAction.get():null;
            }
            public static boolean checkType(String value) {
                return ACTION.convert(value) != null;
            }
            public static boolean checkTypes(String ... values) {
                if(values == null || values.length <= 0) return false;
                return Arrays.stream(values).noneMatch(value -> !ACTION.checkType(value));
            }
            public abstract boolean updateService(Account account, TYPE type);
        }
    }
}
