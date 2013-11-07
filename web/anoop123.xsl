<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : XSLTransformerCode.xsl
    Created on : 12 June 2013, 6:34 PM
    Author     : Lucho
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>XSLTransformerCode.xsl</title>
            </head>
            <body>
                <ul>
                    <xsl:apply-templates select="rss/channel/item"/>
                </ul>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="rss/channel/item">
        <li><a href="{link}"><xsl:value-of select="title"/></a></li>
    </xsl:template>
</xsl:stylesheet>