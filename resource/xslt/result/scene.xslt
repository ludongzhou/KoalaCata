<?xml version="1.0" encoding="UTF-8"?><xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <MetaData>
            <xsl:for-each select="MetaData.Scene">
                <Scene>
                    <Title>
                        <SceneTitle>
                            <xsl:value-of select="MetaData.Scene.Title.SceneTitle"/>
                        </SceneTitle>
                    </Title>
                    <Subject>
                        <xsl:for-each select="MetaData.Scene.Subject.SubjectTerm">
                            <SubjectTerm>
                                <xsl:value-of select="current()"/>
                            </SubjectTerm>
                        </xsl:for-each>
                        <xsl:for-each select="MetaData.Scene.Subject.Keyword">
                            <Keyword>
                                <xsl:value-of select="current()"/>
                            </Keyword>
                        </xsl:for-each>
                    </Subject>
                    <Description>
                        <DescriptionofContent>
                            <xsl:value-of select="MetaData.Scene.Description.DescriptionofContent"/>
                        </DescriptionofContent>
                        <DateofEvent>
                            <xsl:value-of select="MetaData.Scene.Description.DateofEvent"/>
                        </DateofEvent>
                        <NaturalSound>
                            <xsl:value-of select="MetaData.Scene.Description.NaturalSound"/>
                        </NaturalSound>
                    </Description>

                    <Format>
                        <Duration>
                            <xsl:value-of select="MetaData.Scene.Format.Duration"/>
                        </Duration>
                        <StartingPoint>
                            <xsl:value-of select="MetaData.Scene.Format.StartingPoint"/>
                        </StartingPoint>
                        <SubtitleForm>
                            <xsl:value-of select="MetaData.Scene.Format.SubtitleForm"/>
                        </SubtitleForm>
                    </Format>
                </Scene>
            </xsl:for-each>
        </MetaData>
    </xsl:template>
</xsl:stylesheet>