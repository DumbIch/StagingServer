<#macro header>
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <title>${model.titleHeader}</title>
        </head>
        <body style="text-align: left; font-family: sans-serif">
            <img src="/static/atom.jpg">
            <h1>${model.titleHeader}</h1>
            <hr>
            <#nested>
            <hr>
            <a href="/">Back to the main page</a>
            <p><i>${model.titleFooter}</i></p>
        </body>
    </html>
</#macro>