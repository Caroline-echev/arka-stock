package com.project_arka.stock.domain.util;

public class DomainConstants {
    public static final String BRAND_ALREADY_EXISTS_EXCEPTION_MESSAGE = "La marca ya existe";
    public static final String BRAND_NOT_FOUND_EXCEPTION_MESSAGE = "La marca no existe";
    public static final String BRAND_NAME_EMPTY_EXCEPTION_MESSAGE = "El nombre de la marca no puede estar vacio";
    public static final String BRAND_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE = "La descripcion de la marca no puede estar vacia";
    public static final String BRAND_NAME_NUMBER_EXCEPTION_MESSAGE = "El nombre no puede contener solo números";
    public static final String BRAND_NAME_LENGTH_EXCEPTION_MESSAGE = "El nombre no puede exceder los 60 caracteres";
    public static final String BRAND_DESCRIPTION_LENGTH_EXCEPTION_MESSAGE = "La descripción no puede exceder los 200 caracteres";
    public static final String BRAND_LIST_EMPTY_EXCEPTION_MESSAGE = "La lista de marcas esta vacia";
    public static final String CATEGORY_NOT_FOUND_EXCEPTION_MESSAGE = "La categoria no existe";

    public static final String CATEGORY_ALREADY_EXISTS_EXCEPTION_MESSAGE = "La categoria ya existe";
    public static final String CATEGORY_NAME_EMPTY_EXCEPTION_MESSAGE = "La categoria no puede estar vacia";
    public static final String CATEGORY_NAME_LENGTH_EXCEPTION_MESSAGE = "La categoria no puede exceder los 60 caracteres";
    public static final String CATEGORY_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE = "La descripcion de la categoria no puede estar vacia";
    public static final String CATEGORY_DESCRIPTION_LENGTH_EXCEPTION_MESSAGE = "La descripcion de la categoria no puede exceder los 200 caracteres";
    public static final String CATEGORY_LIST_EMPTY_EXCEPTION_MESSAGE = "La lista de categorias esta vacia";
    public static final String SUPPLIER_NAME_EMPTY_EXCEPTION_MESSAGE = "El proveedor debe tener un nombre";
    public static final String SUPPLIER_NAME_LENGTH_EXCEPTION_MESSAGE = "El nombre del proveedor debe tener un maximo de 60 caracteres";
    public static final String SUPPLIER_NIT_EMPTY_EXCEPTION_MESSAGE = "El proveedor debe tener un nit";
    public static final String SUPPLIER_NIT_PATTERN_EXCEPTION_MESSAGE = "El NIT debe ser solo numérico.";
    public static final String SUPPLIER_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE = "La descripción del proveedor no puede estar vacia";
    public static final String SUPPLIER_CONTACT_NAME_EMPTY_EXCEPTION_MESSAGE = "El nombre de contacto es obligatorio.";
    public static final String SUPPLIER_CONTACT_NAME_LENGTH_EXCEPTION_MESSAGE = "El nombre de contacto debe tener un tamaño maximo de 150 caracteres.";
    public static final String SUPPLIER_DESCRIPTION_LENGTH_EXCEPTION_MESSAGE = "La descripción debe tener un máximo de 200 caracteres.";
    public static final String SUPPLIER_EMAIL_PATTERN_EXCEPTION_MESSAGE = "El correo debe tener un formato válido.";
    public static final String SUPPLIER_EMAIL_EMPTY_EXCEPTION_MESSAGE = "El correo es obligatorio.";
    public static final String SUPPLIER_EMAIL_LENGTH_EXCEPTION_MESSAGE = "El correo debe tener un tamaño maximo de 60 caracteres.";
    public static final String SUPPLIER_PHONE_PATTERN_EXCEPTION_MESSAGE = "El teléfono debe empezar con '+' seguido por el prefijo del país y no debe superar los 16 caracteres.";
    public static final String SUPPLIER_PHONE_EMPTY_EXCEPTION_MESSAGE = "El teléfono es obligatorio.";
    public static final String SUPPLIER_PHONE_LENGTH_EXCEPTION_MESSAGE = "El telefono electrónico debe tener un tamaño maximo de 20 caracteres.";
    public static final String SUPPLIER_ADDRESS_EMPTY_EXCEPTION_MESSAGE = "La dirección es obligatoria.";
    public static final String SUPPLIER_ADDRESS_LENGTH_EXCEPTION_MESSAGE = "La dirección debe tener un tamaño maximo de 200 caracteres.";
    public static final String SUPPLIER_WEBSITE_LENGTH_EXCEPTION_MESSAGE = "El sitio web debe tener un tamaño maximo de 500 caracteres.";
    public static final String SUPPLIER_ALREADY_EXISTS_EXCEPTION_MESSAGE = "El proveedor ya existe";
    public static final int CATEGORY_NAME_MAX_LENGTH = 60;
    public static final int CATEGORY_DESCRIPTION_MAX_LENGTH = 200;

    public static final int BRAND_NAME_MAX_LENGTH = 60;
    public static final int BRAND_DESCRIPTION_MAX_LENGTH = 200;

    public static final int SUPPLIER_NAME_MAX_LENGTH = 60;
    public static final int SUPPLIER_CONTACT_NAME_MAX_LENGTH = 150;
    public static final int SUPPLIER_DESCRIPTION_MAX_LENGTH = 200;
    public static final int SUPPLIER_EMAIL_MAX_LENGTH = 60;
    public static final int SUPPLIER_PHONE_MAX_LENGTH = 20;
    public static final int SUPPLIER_ADDRESS_MAX_LENGTH = 200;
    public static final int SUPPLIER_WEBSITE_MAX_LENGTH = 500;
    public static final String NAME_PATTERN = "^(?!\\d+$)[\\w\\s\\d]+$";
    public static final String NUMBER_PATTERN = "\\d+";

    public static final String PHONE_PATTERN = "^\\+[0-9]{1,15}$";

    public  static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

}
