<#import "base_template.ftl" as layout />
<@layout.header>
    <h1>${model.title}</h1>
    <div>
        <h3>
            ${model.columnFileName} : ${model.columnCreatedTime} : ${model.columnLastModificationTime} : ${model.columnMimeType} : ${model.columnFileSize} : ${model.columnFileOrDirectory}
        </h3>
    </div>
    <#list model.listFileInfo as file>
        <div>
            <p>
                ${file.name} : ${file.createdTime} : ${file.lastModifiedTime} : ${file.mimeType} : ${file.size} : ${file.pathType}
            </p>
        </div>
    </#list>
</@layout.header>