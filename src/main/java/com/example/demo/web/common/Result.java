package com.example.demo.web.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 这段代码定义了一个泛型类 Result<T>，表示一个包含操作结果信息的数据结构。具体来说，它有三个成员变量，分别是 code 表示操作结果状态码，message 表示操作结果的消息，data
 * 表示操作结果返回的数据。
 * <p>
 * 这个类还定义了一个静态内部类 ResultBuilder<T>，它用于构建 Result 对象。这个静态内部类里面定义了一些方法，可以设置 code、message、data
 * 等属性，并且提供了一些快捷方法，例如 ok 和
 * error 方法，分别表示操作成功和失败的情况，并且可以传入自定义的消息。此外，还定义了一个 build 方法，用于构建 Result 对象。
 * <p>
 * 这个类使用了 Lombok 提供的注解 @NoArgsConstructor 和 @AllArgsConstructor，分别表示生成一个无参构造函数和一个包含所有成员变量的构造函数。这样做是为了方便使用
 * ResultBuilder 来构建 Result 对象时进行初始化。
 * <p>
 * 这个类还定义了一个静态方法 builder，返回一个 ResultBuilder 对象，用于构建 Result 对象。还有一些静态方法，例如 resultCode、ok 和 error 方法，它们都返回一个
 * ResultBuilder 对象，并且设置了相应的状态码和消息。这样做可以方便用户使用这些快捷方法来构建 Result 对象，而不必自己创建 ResultBuilder 对象并设置相应的属性。
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> ResultBuilder<T> builder() {
        return new ResultBuilder<>();
    }

    public static <T> ResultBuilder<T> resultCode(ResultCodeEnum resultCodeEnum, String... message) {
        return Result.<T>builder().resultCode(resultCodeEnum, message);
    }

    public static <T> ResultBuilder<T> ok(String... message) {
        return Result.resultCode(ResultCodeEnum.SUCCESS, message);
    }

    public static <T> ResultBuilder<T> error(String... message) {
        return Result.resultCode(ResultCodeEnum.FAILED, message);
    }

    public static class ResultBuilder<T> {

        private Integer code;

        private String message;

        private T data;

        public ResultBuilder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        public ResultBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public ResultBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResultBuilder<T> resultCode(ResultCodeEnum resultCodeEnum, String... messages) {
            String message = messages.length == 0 ? resultCodeEnum.getMessage() : String.join(" ", messages);
            return this.code(resultCodeEnum.getCode()).message(message);
        }

        public ResultBuilder<T> ok(String... message) {
            return this.resultCode(ResultCodeEnum.SUCCESS, message);
        }

        public ResultBuilder<T> error(String... message) {
            return this.resultCode(ResultCodeEnum.FAILED, message);
        }

        public Result<T> build() {
            return new Result<>(code, message, data);
        }
    }
}
