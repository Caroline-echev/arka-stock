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
    public static final String CATEGORY_NAME_NUMBER_EXCEPTION_MESSAGE = "La categoria no puede contener solo números";
    public static final String CATEGORY_DESCRIPTION_LENGTH_EXCEPTION_MESSAGE = "La descripcion de la categoria no puede exceder los 200 caracteres";
    public static final String CATEGORY_LIST_EMPTY_EXCEPTION_MESSAGE = "La lista de categorias esta vacia";

    public static final int CATEGORY_NAME_MAX_LENGTH = 60;
    public static final int CATEGORY_DESCRIPTION_MAX_LENGTH = 200;

    public static final int BRAND_NAME_MAX_LENGTH = 60;
    public static final int BRAND_DESCRIPTION_MAX_LENGTH = 200;
    public static final String NAME_PATTERN = "^(?!\\d+$)[\\w\\s\\d]+$";
    public static final String NUMBER_PATTERN = "\\d+";
}
