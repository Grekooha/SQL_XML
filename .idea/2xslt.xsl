<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <entties>
            <xsl:for-each select="entries/entry">
                <entry field="{field}">
                    <xsl:value-of select = "field"/>
                </entry>
            </xsl:for-each>
        </entties>
    </xsl:template>
    </xsl:stylesheet>