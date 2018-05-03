package com.epam.spring.ws.rest.converter;

        import com.epam.view.PdfView;
        import org.springframework.http.HttpInputMessage;
        import org.springframework.http.HttpOutputMessage;
        import org.springframework.http.MediaType;
        import org.springframework.http.converter.AbstractHttpMessageConverter;
        import org.springframework.http.converter.HttpMessageConverter;
        import org.springframework.http.converter.HttpMessageNotReadableException;
        import org.springframework.http.converter.HttpMessageNotWritableException;
        import org.springframework.util.Assert;
        import org.springframework.util.StreamUtils;

        import java.io.IOException;
        import java.io.Reader;
        import java.io.UnsupportedEncodingException;
        import java.io.Writer;
        import java.lang.reflect.ParameterizedType;
        import java.lang.reflect.Type;
        import java.nio.charset.Charset;
        import java.nio.charset.StandardCharsets;
        import java.util.ArrayList;
        import java.util.List;

public class PdfMessageConverter extends AbstractHttpMessageConverter<String> {
    @Override
    protected boolean supports(Class<?> aClass) {
        return true;
    }

    @Override
    protected String readInternal(Class<? extends String> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        try{
            return new PdfView().
        }catch(JsonSyntaxException e){
            throw new HttpMessageNotReadableException("Could not read JSON: " + e.getMessage(), e);
        }

    }

    @Override
    protected void writeInternal(String s, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

    }

//    public PdfMessageConverter() {
//        super(new MediaType("application", "pdf"));
//    }
//
//    @Override
//    protected T readInternal(Class<? extends T> arg0, HttpInputMessage arg1)
//            throws IOException, HttpMessageNotReadableException {
//        Yaml yaml = new Yaml(new Constructor(arg0));
//        T object = (T) yaml.load(arg1.getBody());
//        return object;
//    }
//
//    @Override
//    protected boolean supports(Class<?> arg0) {
//        return true;
//    }
//
//    @Override
//    protected void writeInternal(T arg0, HttpOutputMessage arg1)
//            throws IOException, HttpMessageNotWritableException {
//        Yaml yaml = new Yaml();
//        String result = yaml.dump(arg0);
//        arg1.getBody().write(result.getBytes());
//    }
}